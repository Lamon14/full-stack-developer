import './App.css'
import FooterComponent from './components/FooterComponent'
import EmployeeComponent from './components/EmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import AddEmployeeComponent from './components/AddEmployeeComponent'

function App() {


  return (
    <>
      <BrowserRouter>
        <HeaderComponent/>
        <Routes>
          {/* //http://localhost:3000 */}
          <Route path='/' element={<EmployeeComponent/>}></Route>
          {/* //http://localhost:3000/employees */}
           <Route path='/employees' element={<EmployeeComponent/>}></Route> 
          {/* //http://localhost:3000/add-employee */}
         <Route path='/add-employee' element={<AddEmployeeComponent/>}></Route>

         {/* //http://localhost:3000/edite-employee/1 */}
         <Route path='/edit-employee/:id' element={<AddEmployeeComponent/>}></Route>
        </Routes>
        <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
