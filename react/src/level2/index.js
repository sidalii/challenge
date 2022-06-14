
import '../App.css';
import CardsEqualsToTheDesiredAmount from "../components/CardsEqualsToTheDesiredAmount";

function LevelTwo({ data, setDesiredAmount, onClickDesiredAmount }) {




    const handlePreviousAmountCick = () => {
        const { floor: { value } } = data;

        setDesiredAmount(value)
        onClickDesiredAmount(value)

    }

    const handleNextAmountCick = () => {
        const { ceil: { value } } = data;
        setDesiredAmount(value)
        onClickDesiredAmount(value)

    }


    const renderPossibleAmount = () => {
        if (data && !data.equal) {
            const { ceil, floor } = data;
            return (
                <fieldset>
                    <legend> the desired amount is not available ,please click one of the buttons to have proposition:</legend>
                    {ceil && <button onClick={handleNextAmountCick}>Montant suivant</button>}
                    {floor && <button onClick={handlePreviousAmountCick}>Montant précédent</button>
                    }

                </fieldset>

            )

        }

    }

    return (
        <div className="level-two">
            <div>
                <CardsEqualsToTheDesiredAmount data={data} />
                {renderPossibleAmount()}
            </div>

        </div>

    );
}

export default LevelTwo;
