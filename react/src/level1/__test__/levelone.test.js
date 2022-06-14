import { render, screen, fireEvent, act } from '@testing-library/react';
import LevelOne from '../index';



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


describe("LevelOne component testing", () => {

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
                json: () => Promise.resolve({ ...mockResponseOne }),
            })

        render(<LevelOne />)

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


    test('sould ask the user to choose a possible amount next to its value', async () => {

        global.fetch = () =>
            Promise.resolve({
                json: () => Promise.resolve({ ...mockResponsTwo }),
            })

        render(<LevelOne />)

        await act(async () => {

            addTask(30)
            const buttonElement = await screen.findByText("Submit");
            await fireEvent.click(buttonElement);

        });
        const title = await screen.findByText(/the desired amount is not possible ,please choose a possible amount between this values:/i);
        const floorPossibleAmount = screen.getByText(20);
        const ceilPossibleAmount = screen.getByText(25);

        expect(title).toBeInTheDocument();
        expect(floorPossibleAmount).toBeInTheDocument(floorPossibleAmount);
        expect(ceilPossibleAmount).toBeInTheDocument(ceilPossibleAmount);

    });

})