describe('Teste de Mock de API', () => {
    it('Deve interceptar uma requisição GET e retornar um mock', () => {
        cy.intercept('GET', '/api/users', {
            statusCode: 200,
            body: [
                { id: 1, name: 'João' },
                { id: 2, name: 'Maria' }
            ]
        }).as('getUsers'); // Define um alias para a requisição

        cy.visit('/'); // Acesse a página que consome essa API
        cy.wait('@getUsers'); // Aguarde a requisição ser feita
    });
});

describe('Teste de Mock de API - POST', () => {
    it('Deve interceptar um POST e validar a resposta', () => {
        cy.intercept('POST', '/api/users', {
            statusCode: 201,
            body: { id: 3, name: 'Carlos' }
        }).as('createUser');

        cy.visit('/');
        
        // Simulação de um clique para enviar um novo usuário (ajuste conforme o HTML da página)
        cy.get('#add-user-btn').click();
        
        cy.wait('@createUser').its('response.statusCode').should('eq', 201);
    });
});

describe('Teste de Mock de API - Erro', () => {
    it('Deve simular um erro 500 no servidor', () => {
        cy.intercept('GET', '/api/users', {
            statusCode: 500,
            body: { error: 'Erro no servidor' }
        }).as('getUsersError');

        cy.visit('/');
        
        cy.wait('@getUsersError');
        
        // Valida se a tela mostra uma mensagem de erro (ajuste conforme o HTML da página)
        cy.get('.error-message').should('be.visible');
    });
});
