import React from 'react';

function CommentedContent(props) {
    return props.data.map(datum => <div key={datum}>{datum}</div>);
}

export default CommentedContent;