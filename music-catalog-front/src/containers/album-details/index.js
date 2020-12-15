import React, {Component} from "react";
import axios from 'axios';
import {withRouter} from 'react-router-dom';
import {Row, Col, Typography, Card, Button} from "antd";
import {connect} from 'react-redux';

const {Title, Text} = Typography;

const { Meta } = Card;

class AlbumDetails extends Component
{
    constructor(props) {
        super(props);
        this.state = {
            album: {},
            genre: []
        }
    }

    componentDidMount() {
        console.log(this.props.match.params);
        axios.get(`/api/catalog/songs/${this.props.match.params.id}`)
            .then(res => {
                console.log("song-details res.data", res.data);
                this.setState({song: res.data});
                this.setState({album: res.data.album});
                this.setState({lyrics: res.data.lyrics});
                this.setState({genre: res.data.album.genre});
                if (res.data.artists != null)
                {
                    this.setState({artists: res.data.artists})
                }
                else
                {
                    this.setState({artists: ""})
                }
                console.log("artist res.data", res.data.artists);
            })
            .catch(err => {
                console.log(err)
            })
    }


    render() {
        const {song} = this.state;
        const {album} = this.state;
        const {genre} = this.state;
        const {lyrics} = this.state;
        const {artists} = this.state;
        return (
            <div className={"Song"} >
                <Row style={{marginTop: "100px", display: "flex", alignItems: "center", justifyContent: "center"}}>
                    <Col span={15}>
                        <Card style={{ width: 300 }} cover={<img alt="album" src="/img/album.png"/>}>
                            <Meta
                                title={song.title}
                                description={song.length}
                            />
                            <div style={{display: "flex", flexDirection: "column"}}>
                                <Text style={{fontSize: "1rem"}}>Album: {album.name}</Text>
                                <Text style={{fontSize: "1rem"}}>Genre: {genre.genre}</Text>
                                <Text style={{fontSize: "1rem"}}>Artist: {artists.name}</Text>
                            </div>
                        </Card>
                    </Col>
                </Row>
            </div>
        )
    }
}

export default withRouter(AlbumDetails);