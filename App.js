/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';

import GradientView from 'react-native-linear-gradient';

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
  render() {
    return (
      <View style={styles.container}>
        <GradientView
          style={ styles.gradientRing }
          colors={ ["yellow", "blue"] }
          gradientStart = {{x: 0, y: 0}}
          gradientEnd = {{x: 1, y: 1}}/>
        <Text style={styles.welcome}>Welcome to React Native!</Text>
        <Text style={styles.instructions}>To get started, edit App.js</Text>
        <Text style={styles.instructions}>{instructions}</Text>
      </View>
    );
  }
}

const _userAvatarSize = 160;
const _outerRingSize = _userAvatarSize * 0.625;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  gradientRing: {
    position: 'absolute',
    width: _outerRingSize,
    height: _outerRingSize,
    borderRadius: _outerRingSize / 2,
    opacity: 1
  },
});
