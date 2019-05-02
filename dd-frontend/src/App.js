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
            commentedContent: [],
            contentVal: '',
            commentVal: '',
            commentErrorMessage: '',
            contentErrorMessage: '',
            crossErrorMessage: ''
        }
    }

    componentDidMount() {
        const self = this;
        self.updateCrossData();


        axios.get('http://localhost:8085/comment')
            .then((response) => {
                self.setState({comments: response.data})
            })
            .catch((err) => {
                console.log(err);
            });
    }

    updateCrossData() {
        const self = this;
        axios.get('http://localhost:8085/cross')
            .then((response) => {
                self.setState({commentedContent: response.data})
            })
            .catch((err) => {
                console.log(err);
            });
    }

    addContent() {
        const self = this;
        axios.get("http://localhost:8085/content?suffix=" + self.state.contentVal)
            .then((response) => {
                console.log(self.state);
                const updatedContent = self.state.content.slice();
                updatedContent.push(response.data);
                console.log(updatedContent);
                self.setState({content: updatedContent, contentVal: ''});
            })
            .catch((err) => {
                console.log(err);
                self.setState({contentErrorMessage: err.message}, () => {
                    console.log(self.state.contentErrorMessage);
                })
            });
    }

    addComment() {
        const self = this;
        axios.post('http://localhost:8085/comment', {comment: this.state.commentVal})
            .then(response => {
                const updatedComments = self.state.comments.slice();
                updatedComments.push(response.data);
                self.updateCrossData();
                self.setState({comments: updatedComments, commentVal: ''});
            })
            .catch(err => {
                console.log(err);
                self.setState({commentErrorMessage: err.message});
            })
    }

    updateContentVal(val) {
        this.setState({contentVal: val.target.value});
    }

    updateCommentVal(val) {
        this.setState({commentVal: val.target.value});
    }

    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <section id="main" role="main">
                        <div className={'row'}>
                            <div className='margin-hack col-xs-4'>
                                <CommentSection err={this.state.commentErrorMessage} comments={this.state.comments} commentVal={this.state.commentVal} updateCommentVal={(event) => { this.updateCommentVal(event) }} addComment={() => { this.addComment() } }/>
                            </div>
                            <div className='margin-hack col-xs-4'>
                                <CommentedContent err={this.state.crossErrorMessage} data={this.state.commentedContent}/>
                            </div>
                            <div className='margin-hack col-xs-4'>
                                <ContentSection content={this.state.content} err={this.state.contentErrorMessage} contentVal={this.state.contentVal} updateContentVal={(event) => {this.updateContentVal(event) }} addContent={() => { this.addContent() }}/>
                            </div>
                        </div>
                    </section>
                </header>
            </div>
        );

    }
}

export default App;
