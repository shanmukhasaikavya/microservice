import './App.css';
import Employees from './Component/Employees';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
import AddEmployee from './Component/AddEmployee';



function App() {
  return (
    <Router>
      <Routes>
        <Route>
        <Route path="/" element={<Employees />} component={<Employees />} />
        <Route path="/add" element={<AddEmployee />} component={<AddEmployee />} />
        
        </Route>
      </Routes>
    </Router>
  );
};

export default App;
