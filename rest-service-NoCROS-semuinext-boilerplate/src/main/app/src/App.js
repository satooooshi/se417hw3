import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Button from 'material-ui/Button';
import InputEndWords from "./InputEndWords";


class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to WordLadder App</h1>
        </header>
          <br/>
          <InputEndWords/>
          <br/>
      </div>
    );
  }
}

export default App;
