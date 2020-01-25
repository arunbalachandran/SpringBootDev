import React from 'react';
import ReactDom from 'react-dom';

class Piform extends React.Component {
    constructor(props) {
        super(props);
        this.state = { precision: '' };
    }

    customSubmitHander = async (event) => {
        event.preventDefault();
        console.log("Precision is " + this.state.precision);
        const response = await fetch("http://localhost:8080/", {
            method: 'POST',
            body: JSON.stringify({"precision": this.state.precision}),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        // Note: if you parse the response as a string: you'll run into javascript's floating point limitation
        //       so, fix this by converting the response to text and then parsing out the value 
        const jsonResponse = await response.text();
        // alert("You are submitting: " + this.state.precision);
        console.log("Response is " + jsonResponse);
    }

    customChangeHandler = (event) => {
        this.setState({precision: event.target.value});
    }

    render() {
        return (
            <form onSubmit={this.customSubmitHander}>
                <h1>Please enter the precision you want to calculate Pi for :</h1>
                <input type="text" onChange={this.customChangeHandler} />
                <input type="submit" />
            </form>
        )
    }
}

ReactDom.render(<Piform />, document.getElementById('root'));