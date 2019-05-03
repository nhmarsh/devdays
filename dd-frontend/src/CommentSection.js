import React from 'react';

function CommentSection(props) {
    if(props.err) {
        return <div>Down stop trying</div>
    }

    const length = props.comments.length;

    return (<div>
        <input type={'text'} value={props.commentVal} onChange={props.updateCommentVal}/>
        <button onClick={props.addComment}>Submit</button>

        <div>
            { props.comments.map((datum, index) => {
                if (index >= length - 6) {
                    return <div key={index}>{datum.comment}</div>
                }  else
                    return null;
            } )}
        </div>
    </div>);
}

export default CommentSection;