import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Button from 'material-ui/Button';

const DontPush = () => (
    <Button variant="raised" color="primary">
        Hello World
    </Button>
);

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
          <DontPush/>
          <ItemData/>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

class ItemData extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isLoading: true,
            items: [],
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/api/volumes/')
            .then(response => response.json())
            .then(data => this.setState({items: data, isLoading: false}));
        console.log("Im fetching data:"+this.state.items);


    }

    render() {

        const {items,isLoading} =this.state;

        if(isLoading)
            return(<div>Loading...</div>);

        return (
            <div>
            {
                items.map((item) =>
                <h1>{item.title}</h1>
            )}
            </div>
        );
    }
}

export default App;
