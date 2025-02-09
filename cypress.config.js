const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    baseUrl: "https://www.example.com",
    setupNodeEvents(on, config) {
      // Adicione eventos personalizados aqui, se necessário
    },
  },
});
