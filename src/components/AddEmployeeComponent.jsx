import React, {useState} from 'react'
import { createEmployee, getEmployeeById, updateEmployeeById } from '../service/EmployeeService'
import { useNavigate , useParams} from 'react-router-dom'
import { useEffect } from 'react'

export const AddEmployeeComponent = () => {

    // The useState hook is used to create a state variable and a function to update the state variable
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [jobTitle, setJobTitle] = useState('')
    const [department, setDepartment] = useState('')
    const [salary, setSalary] = useState('')
    const [hireDate, setHireDate] = useState('')
    const [email, setemail] = useState('')
    const [mobileNumber, setMobileNumber] = useState('')
   


    // The useParams hook is used to get the id parameter from the URL
    const {id} = useParams();

    // The useState hook is used to initialize the errors state variable to an empty object  
    const [errors, setErrors] = useState({firtname:'',lastname:'',jobtitle:'',department:'',salary:'',hiredate:'',email:'',mobilenumber:''})

    const navigator = useNavigate();

    useEffect(() => {
        if(id){
            // This function will make a GET request to the API to get the employee by id
            getEmployeeById(id).then(res => {
                let employee = res.data
                setFirstName(employee.firstName)
                setLastName(employee.lastName)
                setJobTitle(employee.jobTitle)
                setDepartment(employee.department)
                setSalary(employee.salary)
                setHireDate(employee.hireDate)
                setemail(employee.email)
                setMobileNumber(employee.mobileNumber)
            }).catch(() => {
                console.log('Error fetching employee by id')
            })
        }

    }, [id])
    // This function will be called when the save button is clicked
    function saveOrUpdateEmployee(e){
        e.preventDefault()

    // This function will check if the form is valid and if it is, it will create a new employee    
        if(validateForm()){
            
            let employee = {firstName: firstName, lastName: lastName, jobTitle: jobTitle, department: department, salary: salary, hireDate: hireDate, email: email, mobileNumber: mobileNumber}
            console.log('Employee => ' + JSON.stringify(employee))

            if(id){
                updateEmployeeById(employee, id).then((response) => {
                    console.log(response.data)
                    navigator('/employees')
                }).catch(() => {
                    console.log('Error updating employee')
                })
            }else{
                // This function will make a POST request to the API to create a new employee
                createEmployee(employee).then(res => {
                    console.log('Employee added successfully')
                    navigator('/employees')
                }).catch(() => {
                    console.log('Error adding employee') 
                }) 
            }
        } 
    }

    function validateForm(){
        let errors = {}
        let formIsValid = true
        if(!firstName){
            formIsValid = false
            errors['firstname'] = 'First Name is required'
        }
        if(!lastName){
            formIsValid = false
            errors['lastname'] = 'Last Name is required'
        }
        if(!jobTitle){
            formIsValid = false
            errors['jobtitle'] = 'Job Title is required'
        }
        if(!department){
            formIsValid = false
            errors['department'] = 'Department is required'
        }
        if(!salary){
            formIsValid = false
            errors['salary'] = 'Salary is required'
        }
        if(!hireDate){
            formIsValid = false
            errors['hiredate'] = 'Hire Date is required'
        }
        if(!email){
            formIsValid = false
            errors['email'] = 'Email is required'
        }
        if(!mobileNumber){
            formIsValid = false
            errors['mobilenumber'] = 'Mobile Number is required'
        }
        setErrors(errors)
        return formIsValid
    }

    // This function will display the page header based on whether the id is present in the URL
    function pageHeader(){
        if(id){
            return <h3 className="text-center">Update Employee</h3>
        }else{
            return <h3 className="text-center">Add Employee</h3>
        }
    }

    // The bootstrap classes are used to style the form
  return (
    <div className='container'>
        <div className="row mt-3">
            <div className="card col-md-6 offset-md-3 offset-md-3">
                {pageHeader()}
                <div className="card-body">
                    <form>
                        <div className="form-group mb-3">
                            <label>First Name:</label>
                            <input placeholder="First Name" name="firstName" className={`form-control ${ errors.firstname ? 'is-invalid' : '' }`} value={firstName} onChange={(e) => setFirstName(e.target.value)}/>
                            {errors.firstname && <div className="invalid-feedback">{errors.firstname}</div>}
                        </div>
                        <div className="form-group mb-3">
                            <label>Last Name:</label>
                            <input placeholder="Last Name" name="lastName" className={`form-control ${ errors.lastname ? 'is-invalid' : '' }`} value={lastName} onChange={(e) => setLastName(e.target.value)}/>
                            {errors.lastname && <div className="invalid-feedback">{errors.lastname}</div>}
                        </div>
                        <div className="form-group mb-3">
                            <label>Job Title:</label>
                            <input placeholder="Job Title" name="jobTitle" className={`form-control ${ errors.jobtitle ? 'is-invalid' : '' }`} value={jobTitle} onChange={(e) => setJobTitle(e.target.value)}/>
                            {errors.jobtitle && <div className="invalid-feedback">{errors.jobtitle}</div>}
                        </div>
                        <div className="form-group mb-3">
                            <label>Department:</label>
                            <input placeholder="Department" name="department" className={`form-control ${ errors.department ? 'is-invalid' : '' }`} value={department} onChange={(e) => setDepartment(e.target.value)}/>
                            {errors.department && <div className="invalid-feedback">{errors.department}</div>}
                        </div>
                        <div className="form-group mb-3">
                            <label>Salary:</label>
                            <input placeholder="Salary" name="salary" className={`form-control ${ errors.salary ? 'is-invalid' : '' }`} value={salary} onChange={(e) => setSalary(e.target.value)}/>
                            {errors.salary && <div className="invalid-feedback">{errors.salary}</div>}
                        </div>
                        <div className="form-group mb-3">
                            <label>Hiredate:</label>
                            <input placeholder="Hire Date" name="hireDate" className={`form-control ${ errors.hiredate ? 'is-invalid' : '' }`} value={hireDate} onChange={(e) => setHireDate(e.target.value)}/>
                            {errors.hiredate && <div className="invalid-feedback">{errors.hiredate}</div>}
                        </div>
                        <div className="form-group mb-3">
                            <label>Email:</label>
                            <input placeholder="Email" name="email" className={`form-control ${ errors.email ? 'is-invalid' : '' }`} value={email} onChange={(e) => setemail(e.target.value)}/>
                            {errors.email && <div className="invalid-feedback">{errors.email}</div>}
                        </div>
                        <div className="form-group mb-3">
                            <label>Mobile Number:</label>
                            <input placeholder="Mobile Number" name="mobileNumber" className={`form-control ${ errors.mobilenumber ? 'is-invalid' : '' }`} value={mobileNumber} onChange={(e) => setMobileNumber(e.target.value)}/>
                            {errors.mobilenumber && <div className="invalid-feedback">{errors.mobilenumber}</div>}
                        </div>
                        <button className="btn btn-success" onClick={saveOrUpdateEmployee}>Save</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
  )
}

export default AddEmployeeComponent