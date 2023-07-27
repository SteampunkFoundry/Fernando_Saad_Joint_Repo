async function getReports() {
    // Get the zip code from the input field
    let zipCode = document.getElementById("zipCode").value;

    // Define a regex for 5 digit ZIP code
    let zipRegex = /^[0-9]{5}$/;

    // Check if the input matches the 5 digit ZIP code format
    if (!zipRegex.test(zipCode)) {
        alert("Please enter a valid 5 digit ZIP code.");
        return;
    }

    // Define your API endpoint with the zip code as a query parameter
    let url = `https://api.fda.gov/food/enforcement.json?search=postal_code:${zipCode}&limit=5`;

    // Fetch the data from the API
    let response = await fetch(url);

    // Check the response status
    if (!response.ok) {
        // If the response status is not ok, throw an error
        throw new Error(`HTTP error! status: ${response.status}`);
    } else {
        // If the response status is ok, parse the JSON data
        let data = await response.json();

        // Clear previous results
        document.getElementById("result").innerHTML = "";

        // Display the data in the "result" div
        data.results.forEach((item, i) => {
            document.getElementById("result").innerHTML +=
                `<p>Report ${i+1}: ${item.product_description}</p>`;
        });
    }
}