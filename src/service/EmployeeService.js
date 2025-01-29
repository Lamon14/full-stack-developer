import axios from 'axios';

const BRAINTRUST_API_BASE_URL = "http://localhost:8080/api/employees";


// This function will make a GET request to the API to get all the employees// can be writte as export const getEmployees = () => axios.get(BRAINTRUST_API_BASE_URL);
export const getEmployees = () => axios.get(BRAINTRUST_API_BASE_URL);

// This function will make a POST request to the API to create a new employee
export const createEmployee = (employee) => axios.post(BRAINTRUST_API_BASE_URL, employee);

// This function will update an employee
export const getEmployeeById = (id) => axios.get(BRAINTRUST_API_BASE_URL + '/' + id);

// This function will update an employee
export const updateEmployeeById = (employee, id) => axios.put(BRAINTRUST_API_BASE_URL + '/' + id, employee);

// This function will delete an employee
export const deleteEmployeeById = (id) => axios.delete(BRAINTRUST_API_BASE_URL + '/' + id);