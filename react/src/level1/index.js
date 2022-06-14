
import { useState, useEffect } from 'react';
import { AvailableAmountProposition, CardsEqualsToTheDesiredAmount } from "../components";
import { endpoints } from '../api';
import '../App.css';


function LevelOne() {
    const [amount, setAmount] = useState('');
    const [data, setData] = useState('');
    const [desiredAmount, setDesiredAmount] = useState('');
    const [test, setTest] = useState("");



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
        await fetch(
            endpoints.combination.search(shopId, amount), {
            headers: {
                'Authorization': 'tokenTest123',
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(async (res) => {
            const data = await res.json()
            setData(data)
            setTest("hello")
        }
        );
    }

    const updateData = (value) => {
        setAmount(value);
        fetchData(shopId, value)
        setDesiredAmount(undefined)

    }


    const handelClick = () => {
        if (amount) {
            fetchData(shopId, amount)

        }
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

    return (
        <div className="container">
            <div className="main-block">
                <h1>  Level 1  </h1>
                <h1>Desired amount:</h1>
                <div className="form-container">
                    <div className="info">
                        <div className="info-item">
                            <input className="amount-input" type="number" value={amount} onChange={handelChange} placeholder="Amount" required />
                        </div>
                    </div>

                    {(!data || (data && data.equal)) && <button onClick={handelClick}>Submit</button>}


                    {/* Level 1  */}
                    <div>
                        {<CardsEqualsToTheDesiredAmount data={data} />
                        }
                        <AvailableAmountProposition
                            data={data}
                            desiredAmount={desiredAmount}
                            setDesiredAmount={setDesiredAmount}
                            onClickDesiredAmount={onClickDesiredAmount} />
                    </div>
                </div>
            </div>
        </div>

    )
}

export default LevelOne;
