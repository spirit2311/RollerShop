var path = require('path');

module.exports = {
  entry: './src/index.tsx',
  devtool: 'source-map',
  cache: true,
  mode: 'development',
  output: {
    path: __dirname,
    filename: './src/main/resources/static/built/bundle.js'
  },
  module: {
    rules: [
      {
        test: path.join(__dirname, '.'),
        exclude: /(node_modules)/,
        use: [{
          loader: 'babel-loader',
          options: {
            presets: ["@babel/preset-env", "@babel/preset-react"]
          }
        }]
      },
      {
        test: /\.tsx?$/,
        use: 'ts-loader',
        exclude: /node_modules/,
      },
    ]
  },
  resolve: {
    extensions: ['.tsx', '.ts', '.js'],
  },
};