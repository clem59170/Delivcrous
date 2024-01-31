#! /bin/env sh

#Changement random pour tester la CI
# Autre changement pour tester la CI
NAMESPACE=europe-west1-docker.pkg.dev/bamboo-machine-407808/imt-delivcrous-registry/
IMAGE_NAME=delivcrous-backend
IMAGE_TAG=1.10.0

# Build Docker image with extra url and access token as build argument
docker build -t "$NAMESPACE$IMAGE_NAME:$IMAGE_TAG" ../
docker push "$NAMESPACE$IMAGE_NAME:$IMAGE_TAG"
