import { render, screen } from '@testing-library/react';
import App from './App';

it('should render the levelOne and levelTwo componenets', () => {

  render(<App />);
  const levelOneTitleElement = screen.getByText(/Level 1/i);
  const levelTwoTitleElement = screen.getByText(/Level 2/i);
  expect(levelOneTitleElement).toBeInTheDocument()
  expect(levelTwoTitleElement).toBeInTheDocument()

});


