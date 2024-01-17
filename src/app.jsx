import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './app.scss';
import routes from './components/routes/Routes';

function App() {
  return (
    <Router basename="/daily">
      <Routes>
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
