import React from 'react';

function ContentSection(props) {

    if(props.err) {
        return <div>The content service is down! <br /> Please try again later</div>
    }

    const length = props.content.length;

    return(
        <div>
            <input type={'text'} value={props.contentVal} onChange={props.updateContentVal} />
            <button onClick={props.addContent}>Submit</button>

            <div>
                { props.content.map((datum, index) => { if (index >= length - 6) return <div key={index}>{datum}</div> } )}
            </div>
        </div>
    )
}

export default ContentSection;