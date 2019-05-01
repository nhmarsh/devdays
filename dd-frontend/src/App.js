import React from 'react';
import axios from 'axios'
import 'bootstrap'
import './App.css';
import CommentSection from "./CommentSection";
import ContentSection from "./ContentSection";
import CommentedContent from "./CommentedContent";

class App extends React.PureComponent {

    constructor(props) {
        super(props);

        this.state = {
            comments: [],
            content: [],
            commentedContent: []
        }
    }

    componentDidMount() {
        const self = this;
        axios.get('http://localhost:8085/cross')
            .then((response) => {
                    self.setState({commentedContent: response.data})
            })
            .catch((err) => {
                console.log(err);
            })
    }


    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <section id="main" role="main">
                        <div className={'row'}>
                            <div className='margin-hack col-xs-4'>
                                <CommentSection/>
                            </div>
                            <div className='margin-hack col-xs-4'>
                                <CommentedContent data={this.state.commentedContent}/>
                            </div>
                            <div className='margin-hack col-xs-4'>
                                <ContentSection/>
                            </div>
                        </div>
                    </section>
                </header>
            </div>
        );

    }
}

export default App;
