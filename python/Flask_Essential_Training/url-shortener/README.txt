to start the server using Gunicorn run:
gunicorn "urlshort:create_app()" -b 0.0.0.0