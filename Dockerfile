# Use the Nginx image as a base
FROM nginx:alpine

# Copy the HTML file to the Nginx web directory
COPY index.html /usr/share/nginx/html
COPY FDAapiScript.js /usr/share/nginx/html/js/

# Use port 80
EXPOSE 80
