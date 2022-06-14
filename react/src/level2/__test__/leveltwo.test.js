import { render, screen, fireEvent, act } from '@testing-library/react';
import LevelTwo from '../index';



const mockResponseOne = {
    equal: {
        value: 20, cards: [20]
    },
    floor: {
        value: 20, cards: [20]
    },
    ceil: {
        value: 25, cards: [20]
    }


}

const mockResponsTwo = {
    floor: {
        value: 20, cards: [20]
    },
    ceil: {
        value: 25, cards: [20]
    }


}


describe("LevelTwo component testing", () => {

    beforeEach(() => {
        window.alert = jest.fn();
    });

    afterEach(() => {
        jest.restoreAllMocks();
    });



    const addTask = (task) => {
        const inputElement = screen.getByPlaceholderText(/Amount/i);
        fireEvent.change(inputElement, { target: { value: task } });
    }

    test('should fetch data and return the amount consists of the following cards asked by user', async () => {

        global.fetch = () =>
            Promise.resolve({
                json: () => Promise.resolve(mockResponseOne),
            })

        render(<LevelTwo />)

        await act(async () => {

            addTask(20)
            const buttonElement = await screen.findByText("Submit");
            await fireEvent.click(buttonElement);

        });

        const titleResult = await screen.findByTestId("custom-element");

        const amountConsistsOfcards = await screen.findByText(20);

        expect(titleResult).toBeInTheDocument(titleResult);
        expect(titleResult).toBeInTheDocument(amountConsistsOfcards);

    });


    test('sould allow the user to ask for the next amounts thanks to minus and plus buttons.', async () => {

        global.fetch = () =>
            Promise.resolve({
                json: () => Promise.resolve(mockResponsTwo),
            })

        render(<LevelTwo />)

        await act(async () => {

            addTask(30)
            const buttonElement = await screen.findByText("Submit");
            await fireEvent.click(buttonElement);

        });
        const title = await screen.findByText(/the desired amount is not available ,please click one of the buttons to have proposition:/i);

        const nextAmoutButton = await screen.findByText(/Next amount/i);
        const previousAmoutButton = await screen.findByText(/Previous amount/i);


        expect(title).toBeInTheDocument();
        expect(nextAmoutButton).toBeInTheDocument(nextAmoutButton);
        expect(previousAmoutButton).toBeInTheDocument(previousAmoutButton);

    });



    test('should hide submit button if data is not null and doesnt contain equal object', async () => {

        global.fetch = () =>
            Promise.resolve({
                json: () => Promise.resolve(mockResponsTwo),
            })

        render(<LevelTwo />)

        await act(async () => {

            addTask(20)
            const submitButton = await screen.findByText("Submit");
            await fireEvent.click(submitButton);
        });

        const submitButton = screen.queryByText('Submit')
        expect(submitButton).toBeNull()

    });

})