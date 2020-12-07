import React, { Component } from 'react';
import {Row, Col} from 'antd';
import { Menu } from 'antd';
import './header.css';
import {Link, withRouter} from "react-router-dom";

const logo = "/img/Logo.png";

class Header extends Component
{
    render () {

        let img = (
            <Link to={"/"}><img className={"logo"} src={logo} alt={"logo"}/></Link>
        )

        let menu = (
            <Menu mode={"horizontal"} style={{width: "100%"}}>
                <Menu.Item key={1}><Link to={"/"} style={{textDecoration: "none", color: "#000"}}>Home</Link></Menu.Item>
                <Menu.Item key={2}><Link to={"/"} style={{textDecoration: "none", color: "#000"}}>Songs</Link></Menu.Item>
                <Menu.Item key={3}><Link to={"/"} style={{textDecoration: "none", color: "#000"}}>Albums</Link></Menu.Item>
            </Menu>
        );

        return (
            <header className={"header"}>
                <Row style={{display: "flex", alignItems: "center", justifyContent: "space-between", width: "60%", height: "80px", margin: "0 auto"}}>
                    <Col span={12}>
                        {img}
                    </Col>
                    <Col span={24} style={{display: "flex", alignItems: "center", justifyContent: "flex-end", width: "400px"}}>
                        {menu}
                    </Col>
                </Row>
            </header>
        )
    }
}

export default withRouter(Header);