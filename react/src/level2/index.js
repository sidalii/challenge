import { useState, useEffect } from 'react';
import { CardsEqualsToTheDesiredAmount } from "../components";
import { endpoints } from '../api';
import '../App.css';


function LevelTwo() {
    const [amount, setAmount] = useState('');
    const [data, setData] = useState('');

    const shopId = 5;


    useEffect(() => {
        const { floor, ceil, equal } = data || {};
        if (!equal) {
            if (ceil && !floor) {
                updateData(ceil.value)
            } else if (floor && !ceil) {
                updateData(floor.value)
            }
        }
    }, [data])

    const handelChange = (e) => {
        setAmount(e.target.value)
    }



    const fetchData = async (shopId, amount) => {
        try {
            await fetch(
                endpoints.combination.search(shopId, amount), {
                headers: {
                    'Authorization': 'tokenTest123',
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            }).then(async (res) => {
                const data = await res.json()
                setData(data)
            }
            );
        } catch (error) {
            alert(error + ": please run first the mock server is provided in the `server` folder")
        }
    }

    const updateData = (value) => {
        setAmount(value);
        fetchData(shopId, value)

    }


    const handelClick = () => {
        if (amount)
            fetchData(shopId, amount)
        else {
            alert("please type your amount!")
        }
    }


    const onClickDesiredAmount = (value) => {
        if (value) {
            updateData(value)
        } else {
            alert("please choose an amount!")
        }
    }


    const handlePreviousAmountCick = () => {
        const { floor: { value } } = data;

        onClickDesiredAmount(value)

    }

    const handleNextAmountCick = () => {
        const { ceil: { value } } = data;
        onClickDesiredAmount(value)

    }


    const renderPossibleAmount = () => {
        if (data && !data.equal) {
            const { ceil, floor } = data;
            return (
                <fieldset>
                    <h2> the desired amount is not available ,please click one of the buttons to have proposition:</h2>
                    {ceil && <button className="next-amount-btn" onClick={handleNextAmountCick}>Next amount</button>}
                    {floor && <button className="previous-amount-btn" onClick={handlePreviousAmountCick}>Previous amount</button>
                    }
                </fieldset>
            )
        }

    }

    return (


        <div className="container">
            <div className="main-block">
                <h1>  Level 2  </h1>
                <h1>Desired amount:</h1>
                <div className="form-container">
                    <div className="info">
                        <div className="info-item">
                            <input className="amount-input" type="number" value={amount} onChange={handelChange} placeholder="Amount" required />
                        </div>
                    </div>

                    {(!data || (data && data.equal)) && <button onClick={handelClick}>Submit</button>}
                    <div>
                        <CardsEqualsToTheDesiredAmount data={data} />
                        {renderPossibleAmount()}
                    </div>
                </div>
            </div>
        </div>

    )
}

export default LevelTwo;
