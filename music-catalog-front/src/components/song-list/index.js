import React, { Component } from 'react';
import { List, Row, Col } from 'antd'
import {withRouter} from 'react-router-dom'
import axios from 'axios'
import './song-list.css';
import {PlaySquareOutlined} from '@ant-design/icons';

class SongList extends Component{

    constructor(){
        super()
        this.state = {
            songs: [],
            artists:{},
            count: 0
        }
    }

    onClick = (id) => {
        return () => {
            this.props.history.push(`/songs/${id}`)
        }
    }

    componentDidMount()
    {
        axios.get('/api/catalog/songs')
            .then(res => {
                this.setState({songs: res.data});
                console.log("song res.data", res.data);
                console.log("artists res.data", res.data.artists);
            })
            .catch(err => {
                console.log(err)
            })
    }


    render(){
        const {songs} = this.state;
        console.log(songs)
        const songsList =
            songs.map(item =>(
                <div className={"song-row"} onClick={this.onClick(item.id)}>
                    <PlaySquareOutlined />
                    <div style={{display: "flex", flexDirection: "row", alignItems: "center", justifyContent: "space-between", width: "100%" }}>
                        <h3 style={{fontWeight: "normal", margin: "20px"}}>{item.title}</h3>
                        <p style={{fontWeight: "normal", margin: "0"}}>{item.length}</p>
                    </div>
                </div>
            ))

        return (
            <div style={{marginBottom: "80px"}}>
                <div style={{marginTop: "90px"}}>
                    <h1 style={{fontWeight: "normal"}}>
                        All songs
                    </h1>
                </div>
                {this.state.name}
                <Row gutter = {16} className={"song-list-row"} style={{display: "flex",
                    justifyContent: "left",
                    alignItems: "center",
                    flexWrap: "wrap",
                    paddingLeft: "12%",
                    paddingRight: "12%",
                    marginLeft: "0!important",
                    marginRight: "0!important"
                }}>
                    <Col span={24} style={{width: "100%", display: "flex", flexDirection: "column", alignItems: "center"}}>
                        {songsList}
                    </Col>

                </Row>
            </div>

        )
    }
}

export default withRouter(SongList);