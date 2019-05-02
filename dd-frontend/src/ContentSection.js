import React from 'react';

function ContentSection(props) {

    if(props.err) {
        return <div>The content service is down! Please try again later</div>
    }

    return(
        <div>
            <input type={'text'} value={props.contentVal} onChange={props.updateContentVal} />
            <button onClick={props.addContent}>Submit</button>

            <div>
                { props.content.map((datum, index)=> <div key={index}>{datum}</div>) }
            </div>
        </div>
    )
}

export default ContentSection;