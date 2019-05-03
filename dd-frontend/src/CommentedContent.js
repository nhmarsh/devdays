import React from 'react';

function CommentedContent(props) {
    const length = props.data.length;
    return props.data.map((datum, index) => {
        if(index >= length - 6) return <div key={datum + index}>{datum}</div>
    });
}

export default CommentedContent;