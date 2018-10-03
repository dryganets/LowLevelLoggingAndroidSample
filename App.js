/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, ScrollView, StyleSheet, Text, View} from 'react-native';

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
      <ScrollView>
        <Text style={styles.welcome} selectable={true} numberOfLines={0}>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed interdum diam odio. Etiam porta dui sed felis vestibulum tempor. Maecenas eu neque lectus. Ut iaculis porttitor enim, at molestie nisi fringilla vitae. Pellentesque imperdiet cursus nisl, id accumsan leo scelerisque aliquam. Morbi posuere tortor erat, sed sagittis elit dapibus sed. Vestibulum faucibus purus eget ante viverra viverra. Aliquam nec faucibus quam. Suspendisse dui erat, ultricies nec fermentum sit amet, vehicula volutpat tellus. Proin sed dictum justo, vel mollis felis. Sed vel posuere erat. Donec lorem lacus, fringilla in erat in, mollis dapibus turpis. Sed sed ultricies risus, at convallis justo. Nullam cursus justo sed dapibus mollis.

Integer feugiat arcu ac velit aliquam porttitor. Pellentesque vitae consequat orci. Aliquam ut tellus vulputate, blandit risus ut, dignissim est. Fusce dolor turpis, egestas id vestibulum mollis, feugiat vitae felis. Quisque sit amet sapien id nunc rhoncus varius vel venenatis diam. Fusce interdum nibh in lacus pretium posuere. Pellentesque non mollis massa. Praesent pulvinar fringilla ullamcorper. Curabitur porttitor, arcu eget dignissim tempor, erat lectus sollicitudin enim, a tempor quam nibh at sem. Sed id efficitur nulla, quis placerat mi. Sed faucibus massa nulla, vel vestibulum erat ultricies sed. Pellentesque scelerisque elementum dictum. Nullam sit amet erat et urna rutrum cursus. Etiam tincidunt dui a massa dignissim, tincidunt pulvinar est rutrum. Nam et blandit mi.

Nullam in ante tincidunt, suscipit risus sed, dignissim diam. Donec cursus tortor odio. Curabitur dui urna, elementum quis finibus nec, elementum nec ligula. Cras tempor dignissim gravida. Proin finibus purus id accumsan sodales. Suspendisse a hendrerit nulla, non fringilla mi. Proin scelerisque tortor non finibus accumsan. Vestibulum tristique egestas nibh ac pulvinar.

Curabitur elementum dignissim purus, a pretium sem congue ullamcorper. Donec sit amet tristique quam, sit amet porttitor nisl. In hac habitasse platea dictumst. Morbi ut justo quis nibh consequat semper vel eu turpis. Maecenas commodo maximus nisl a vehicula. Phasellus facilisis sagittis ligula, id ultrices lectus egestas sit amet. Pellentesque ac scelerisque leo. Nullam aliquet malesuada sapien, eu pulvinar mauris.

Donec suscipit vel sapien sed consectetur. Sed bibendum porta bibendum. Maecenas id nulla eget dui elementum cursus eu non eros. Maecenas id accumsan mi. Donec quam leo, volutpat ut molestie et, vulputate id quam. Donec pulvinar enim elit, quis rutrum lorem congue quis. Quisque ac lacinia lorem, eu scelerisque felis. Vivamus eu venenatis nisi, tristique fermentum ex. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer congue sit amet urna vel rhoncus. Vestibulum accumsan lacus tellus, non tristique libero finibus vitae. Nam id purus bibendum, finibus lorem id, vestibulum est. Sed et massa quis tortor pellentesque facilisis sed in metus.</Text>
        <Text style={styles.instructions}>To get started, edit App.js</Text>
        <Text style={styles.instructions}>{instructions}</Text>
        </ScrollView>
      </View>
    );
  }
}

/*
numberOfLines: 0,
    
    selectable: true,
*/
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
    overflow: 'visible'
  },
  welcome: {
    fontSize: 22,
    textAlign: 'center',
    fontFamily: 'san-serif',
    fontSize: 17,
    lineHeight: 22,
    letterSpacing: -0.2,
    color: '#FFFFFF',
    backgroundColor: "#000000",
    alignSelf: 'stretch',
    overflow: 'visible',
    fontWeight: "400",
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
