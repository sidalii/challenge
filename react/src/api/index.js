const server = 'http://localhost:3000';

export const endpoints = {

    combination: {

        search: (shopId, amount) => `${server}/shop/${shopId}/search-combination?amount=${amount}`,

    },

}