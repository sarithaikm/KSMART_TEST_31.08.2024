HRMS application is designed to manage employee records
Entity: hrmsModel

empid: UUID, primary key (auto-generated)
fullname: String, cannot be empty
designation: String, cannot be empty
mobile: String, must be exactly 10 digits
email: String, must be a valid email address
dateOfBirth: LocalDate, must be a past date

Fields are validated 
Configure database connection details in application.properties

Input

{
    "fullname": "Saritha",
    "designation": "TA",
    "mobile": "1234567890",
    "email": "sarithabs@gmail.com",
    "dateOfBirth": "1990-04-25"
}