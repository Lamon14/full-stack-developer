import React ,{useEffect, useState} from 'react'
import { getEmployees, deleteEmployeeById } from '../service/EmployeeService'
import { useNavigate } from 'react-router-dom'

const EmployeeComponent = () => {

    // The useState hook is used to create a state variable and a function to update the state variable
    const [employees, setEmployees] = useState([])
    const navigator = useNavigate();

    // This function will make a GET request to the API to get all the employees
    useEffect(() => {
        getEmployees().then((response) => {
            setEmployees(response.data)
        })
    }, [])

function addNewEmployee(){
    navigator('/add-employee')
}

function updateEmployee(id){
    navigator('/edit-employee/' + id)
    //navigator(`/edit-employee/${id}´)   
}

// This function will remove an employee by id
function removeEmployee(id){
    console.log('Employee Id => ' + id)
    deleteEmployeeById(id).then(() => {
        console.log('Employee deleted successfully')
        setEmployees(employees.filter(employee => employee.id !== id))
    }).catch(() => {
        console.log('Error deleting employee')
    })
    
}

  return (
    // The bootstrap classes are used to style the table
    <div className='container'>
        <h2 className="text-center">List of Employees</h2>
        <button className="btn btn-primary mb-2" onClick={addNewEmployee}>Add Employee</button>
        <table className='table table-striped table-bordered'> 
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Job Title</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Hire Date</th>
                    <th>Email</th>
                    <th>Mobile Number</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee => 
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.jobTitle}</td>
                            <td>{employee.department}</td>
                            <td>{employee.salary}</td>
                            <td>{employee.hireDate}</td>
                            <td>{employee.email}</td>
                            <td>{employee.mobileNumber}</td>
                            <td>
                                <button className="btn btn-info" onClick={() => updateEmployee(employee.id)}>Update</button>
                                <button className="btn btn-danger" onClick={() => removeEmployee(employee.id)}
                                    style={{marginLeft: '20px'}}>Delete</button>    
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default EmployeeComponent