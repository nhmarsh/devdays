import React from 'react';

function ContentSection(props) {

    return(
        <div>
            <input type={'text'} value={props.contentVal} onChange={props.updateContentVal} />
            <button onClick={props.addContent}>Submit</button>

            <div>
                { props.content.map(datum => <div key={datum}>{datum}</div>) }
            </div>
        </div>
    )
}

export default ContentSection;