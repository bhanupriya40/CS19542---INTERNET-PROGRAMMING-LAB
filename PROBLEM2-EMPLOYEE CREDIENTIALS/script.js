function generateCredentials(names) {
    const output = names.split(" ").map(name => {
        let [firstName, lastName] = name.split("_");
        let email = `${firstName.toLowerCase()}.${lastName.toLowerCase()}@abc.com`;
        let username = `${firstName.toLowerCase()}${lastName.charAt(0).toUpperCase() + lastName.slice(1).toLowerCase()}`;
        let password = `${lastName.toLowerCase()}#${firstName.charAt(0).toUpperCase() + firstName.slice(1).toLowerCase()}`;
        return `<h2>${firstName} ${lastName}</h2><h2>${email}</h2><h2>${username}</h2><h2>${password}</h2>`;
    }).join("");
    document.getElementById("solution").innerHTML = output;
}
let input = "Lionel_Messi Cristiano_Ronaldo Luis_Suarez";
generateCredentials(input);
