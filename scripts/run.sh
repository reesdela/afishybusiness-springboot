docker build --no-cache -t afishybusiness-backend .
docker run -dp 127.0.0.1:8080:8080 --network afishybusiness_default afishybusiness-backend