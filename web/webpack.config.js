const path = require('path');
const webpack = require('webpack');

module.exports = {
    entry: {
        main: './src/main/resources/static/js/LoginPage.js',
        registration: './src/main/resources/static/js/RegistrationPage.js'
    },

    plugins: [
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery'
        })
    ],
    output: {
        path: path.resolve(__dirname, './src/main/resources/static/dist')
    },
    mode: 'development',
    devtool: 'inline-source-map'
};