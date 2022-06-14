
import '../App.css';


function CardsEqualsToTheDesiredAmount({ data }) {
    return data && data.equal ?
        <div>
            <h2 data-testid="custom-element">Your amount consists of the following cards :</h2>
            {data.equal.cards.map((amount, index) => <h1 key={index}><strong>{amount}</strong></h1>)}

        </div> : null

}



export default CardsEqualsToTheDesiredAmount;
