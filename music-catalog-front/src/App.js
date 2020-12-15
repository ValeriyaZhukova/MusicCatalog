import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route } from "react-router-dom";
import Header from "./components/header";
import SongList from "./components/song-list";
import SongDetails from "./containers/song-details";
import AlbumList from "./components/album-list";
import AlbumDetails from "./containers/album-details";

function App() {
  return (
        <div className="App" style={{paddingBottom: "80px"}}>
          <Router>
            <Header/>
            <Route path="/" exact component={SongList}/>
            <Route path="/albums" exact component={AlbumList}/>
            <Route path="/songs/:id" exact component={SongDetails}/>
          </Router>
        </div>
  );
}

export default App;
