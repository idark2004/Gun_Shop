import './App.css';
import Register from './components/Register';
import Login from './components/Login';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Navbar} from './components/Navbar';
import Homepage from './components/Index';
import Product from './components/Product';
import ProductDetail from './components/ProductDetail';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path='/' element={<Homepage />} />
        <Route path='/product' element={<Product/>}/>
        <Route path='/register' element={<Register />} />
        <Route path='/login' element={<Login />} />
        <Route path='/product-detail/:id' element={<ProductDetail />} />
      </Routes>
    </BrowserRouter >
  );
}

export default App;
