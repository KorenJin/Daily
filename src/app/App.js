import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Home from '../pages/homepage/Home';
import routes from '../pages/routes/Routes';

function App() {
  return (
    <Router basename="/daily">
      <Routes>
        <Route path='/' element={<Home />} />
        {
          routes.map((route, index) => (
              <Route key={index} path={route.path} exact element={<route.component />} />
            )
          ) 
        }
      </Routes>
    </Router>
  );
}

export default App;
