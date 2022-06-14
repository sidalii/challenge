function AvailableAmountProposition({ data, desiredAmount, setDesiredAmount, onClickDesiredAmount }) {

    if (data && !data.equal) {
        const { ceil, floor } = data || {};
        return ceil && floor ? (

            <div className="grade-type">
                <h2>the desired amount is not possible ,please choose a possible amount between this values:</h2>


                {ceil &&
                    <div>
                        <input
                            className="amount-proposed"
                            type="checkbox"
                            id={ceil.value}
                            onChange={() => { setDesiredAmount(ceil.value) }}
                            checked={desiredAmount === ceil.value} />
                        <label className="amount-value" htmlFor={ceil.value}>{ceil.value}</label>
                    </div>

                }

                {data.floor &&
                    <div>
                        <input type="checkbox"
                            className="amount-proposed"
                            id={floor.value}
                            onChange={() => { setDesiredAmount(floor.value) }}
                            checked={desiredAmount === floor.value} />
                        <label className="amount-value" htmlFor={floor.value}>{floor.value}</label>
                    </div>

                }
                <button onClick={() => { onClickDesiredAmount(desiredAmount) }}>Submit</button>
            </div>
        ) : <></>

    } else {
        return <></>
    }

}

export default AvailableAmountProposition;