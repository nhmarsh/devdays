import React from 'react';

function CommentSection(props) {
    if(props.err) {
        return <div>Down stop trying</div>
    }
    return (<div>
        <input type={'text'} value={props.commentVal} onChange={props.updateCommentVal}/>
        <button onClick={props.addComment}>Submit</button>

        <div>
            {props.comments.map(datum => <div key={datum}>{datum.comment}</div>)}
        </div>
    </div>);
}

export default CommentSection;