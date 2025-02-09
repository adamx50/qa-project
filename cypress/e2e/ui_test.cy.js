describe('Teste de UI com Cypress', () => {
    it('Verifica o título da página', () => {
        cy.visit('/'); // Agora usamos a URL base
        cy.title().should('eq', 'Example Domain');
    });
});
