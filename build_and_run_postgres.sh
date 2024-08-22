#!/bin/bash

# Set environment variables for PostgreSQL
POSTGRES_USER="postgres"
POSTGRES_PASSWORD="mysecretpassword"
POSTGRES_DB="postgres"
CONTAINER_NAME="my_postgres_container"
IMAGE_NAME="my_postgres_image"

# Create a Dockerfile for PostgreSQL
cat <<EOF > Dockerfile
FROM postgres:latest

ENV POSTGRES_USER=$POSTGRES_USER
ENV POSTGRES_PASSWORD=$POSTGRES_PASSWORD
ENV POSTGRES_DB=$POSTGRES_DB

# Add a script to create the schema
COPY create_schema.sh /docker-entrypoint-initdb.d/
EOF

# Create the script to create the "study" schema
cat <<'EOF' > create_schema.sh
#!/bin/bash
set -e
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE SCHEMA study;
EOSQL
EOF

# Build the Docker image
docker build -t $IMAGE_NAME .

# Clean up the Dockerfile and schema script after building the image
rm Dockerfile create_schema.sh

# Run the PostgreSQL container from the built image
docker run --name $CONTAINER_NAME \
  -p 5432:5432 \
  -d $IMAGE_NAME

echo "PostgreSQL container is running from the image $IMAGE_NAME."
echo "Username: $POSTGRES_USER"
echo "Password: $POSTGRES_PASSWORD"
echo "Database: $POSTGRES_DB"
echo "Schema 'study' has been created."
echo "Access the database on port 5432."

