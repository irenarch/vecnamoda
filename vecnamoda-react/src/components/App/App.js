import './App.css';
import React, {useState} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';

import Menu from "../Menu/Menu"
import Intro from "../Intro/Intro";
import Shop from "../Shop/Shop";
import Sell from "../Sell/Sell";
import Register from "../Register/Register";
import Login from "../Login/Login";
import Account from "../Account/Account";
import About from "../About/About";
import MyItems from "../MyItems/MyItems";
import MyOrders from "../MyOrders/MyOrders";
import ShoppingCart from "../ShoppingCart/ShoppingCart";
import CheckOut from "../CheckOut/CheckOut";
import Article from "../Article/Article";
// import SidebarFilter from "../SidebarFilter/SidebarFilter";


import Container from "react-bootstrap/Container";


const CartContext = React.createContext({items: [], total: 0});

function App() {
    // const [cart, setCart] = useState({items:[], total:0});

    return (
        <CartContext.Provider value={ { items: [], total: 0 } }>
            <Container id={global}>
                <Router>
                    <Menu/>
                    <Routes>
                        <Route path="/" element={<Intro/>}/>
                        <Route path="/shop" element={<Shop/>}/>
                        <Route path="/sell" element={<Sell/>}/>
                        <Route path="/register" element={<Register/>}/>
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/account" element={<Account/>}/>
                        <Route path="/about" element={<About/>}/>
                        <Route path="/myitems" element={<MyItems/>}/>
                        <Route path="/myorders" element={<MyOrders/>}/>
                        <Route path="/shoppingcart" element={<ShoppingCart/>}/>
                        <Route path="/checkout" element={<CheckOut/>}/>
                        <Route path="/shop/:id" element={<Article/>}/>
                    </Routes>
                </Router>
            </Container>
        </CartContext.Provider>
    );

}

export default App;