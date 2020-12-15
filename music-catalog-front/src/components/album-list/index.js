import React, { Component } from 'react';
import {List, Row, Col, Card} from 'antd'
import {withRouter} from 'react-router-dom'
import axios from 'axios'
import './album-list.css';
import {PlaySquareOutlined} from "@ant-design/icons";

class AlbumList extends Component {
    constructor(){
        super()
        this.state = {
            albums: [],
            genres: {},
        }
    }

    onClick = (id) => {
        return () => {
            this.props.history.push(`/albums/${id}`)
        }
    }

    componentDidMount()
    {
        axios.get('/api/catalog/albums')
            .then(res => {
                this.setState({albums: res.data});
                console.log("albums res.data", res.data);
                console.log("genres res.data", res.data.genre);
            })
            .catch(err => {
                console.log(err)
            })
    }


    render(){
        const {albums} = this.state;
        const {genres} = this.state
        console.log(albums)
        const albumList =
            albums.map(item =>(
                <div className={"album-row"} onClick={this.onClick(item.id)}>
                    <div style={{display: "flex", flexDirection: "row", alignItems: "center", justifyContent: "center"}}>
                        <h3 style={{fontWeight: "normal", margin: "20px"}}>{item.name}</h3>
                        <p style={{fontWeight: "normal", margin: "0"}}>{item.length}</p>
                        <p style={{fontWeight: "normal", margin: "0"}}>{genres.genre}</p>
                    </div>
                </div>
            ))

        return (
            <div className={"Album"} >
                <Row style={{marginTop: "100px", display: "flex", alignItems: "center", justifyContent: "center", flexDirection: "center"}}>
                    <Col span={15}>
                        <Card style={{ width: 300 }}>
                            <div style={{display: "flex", flexDirection: "column"}}>
                                {albumList}
                            </div>
                        </Card>
                    </Col>
                </Row>
            </div>

        )
    }
}

export default withRouter(AlbumList);
