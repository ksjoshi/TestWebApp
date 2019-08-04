const path = require('path');
const webpack = require('webpack');

module.exports = {
    entry: './src/main/resources/static/js/LoginPage.js',
    plugins: [
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery'
        })
    ],
    output: {
        filename: 'main.js',
        path: path.resolve(__dirname, './src/main/resources/static/dist')
    },
    mode: 'development',
    devtool: 'inline-source-map'
};