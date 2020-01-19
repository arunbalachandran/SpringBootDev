import React from 'react';
import ReactDOM from 'react-dom';

class Picalc extends React.Component {
  constructor() {
    super();
    this.state = {
      piprecision: 0,
      response: 3.14
    }
  }

  handleChange(e) {
    console.log("change detected");
    this.setState({piprecision: e.target.value});
  }

  handleClick() {
    console.log("Input passed in was : " + this.state.piprecision);
    fetch('http://localhost:8080')
    .then(response => {
      console.log("Response is : " + response);
      // this.setState("pi", response)
    })
  }

  render() {
    return (
      <div className="Picalc">
        <input type="text" onChange={ (e) => this.handleChange(e) } />
        <input type="button" value="Pi Precision in digits" onClick={ () => this.handleClick() } />
      </div>
    );
  }
}

ReactDOM.render(
  <Picalc />,
  document.getElementById('root')
);