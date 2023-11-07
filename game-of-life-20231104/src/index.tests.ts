import { describe, expect, test } from 'vitest'
import {
  bestimmeHabitatFuer,
  type Board,
  entferneDoppelte,
  kandidatenFuer,
  kandidatenFuerBoard,
  lebtNaechsteRunde,
  nachXY,
  tick,
} from './index.js'

test('Position nach x,y', () => {
  const { x, y } = nachXY('22/6')
  expect(x).toEqual(22)
  expect(y).toEqual(6)
})

describe('alle positionen in direkter nachbarschaft einer lebenden zelle sind kandidaten fuer lebende zellen im naechsten zug', () => {
  test('fuer jede position gibt es 9 kandidaten', () => {
    //prettier-ignore
    expect(kandidatenFuer('3/3')).toEqual([
            '2/2', '3/2', '4/2',
            '2/3', '3/3', '4/3',
            '2/4', '3/4', '4/4',
        ])
  })
  test('Leeres Board hat keine Kandidaten', () => {
    const board: Board = []
    expect(kandidatenFuerBoard(board)).toEqual([])
  })

  test('Board mit 1 Pos', () => {
    const board: Board = ['3/3']
    //prettier-ignore
    expect(kandidatenFuerBoard(board)).toEqual([
            '2/2', '3/2', '4/2',
            '2/3', '3/3', '4/3',
            '2/4', '3/4', '4/4',
        ])
  })
})

test('habitat fuer eine lebende zelle ohne nachbarn', () => {
  const { status, nachbarn } = bestimmeHabitatFuer('5/5', ['5/5'])
  expect(status).toEqual('lebt')
  expect(nachbarn).toEqual(0)
})

test('habitat fuer eine tote zelle', () => {
  const board = ['5/5'] satisfies Board
  const { status, nachbarn } = bestimmeHabitatFuer('4/5', board)
  expect(status).toEqual('tod')
  expect(nachbarn).toEqual(1)
})

test('nur lebende zellen zaehlen als nachbarn', () => {
  //prettier-ignore
  //@formatter:off
  const {status, nachbarn} = bestimmeHabitatFuer('5/5', [
               '5/6',
        '4/5',        '6/5',
               '5/4',
    ])
  //@formatter:on
  expect(status).toEqual('tod')
  expect(nachbarn).toEqual(4)
})

test('entferne doppelte positionen', () => {
  expect(entferneDoppelte(['1/1', '2/2', '1/1', '1/1'])).toEqual(['1/1', '2/2'])
})

describe('regeln', () => {
  describe('lebende zelle', () => {
    test('mit weniger als zwei nachbarn stirbt', () => {
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 0 })).toEqual(false)
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 1 })).toEqual(false)
    })
    test('mit 2 oder 3 nachbarn ueberlebt', () => {
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 2 })).toEqual(true)
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 3 })).toEqual(true)
    })
    test('mit 4 oder mehr nachbarn stirbt', () => {
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 4 })).toEqual(false)
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 5 })).toEqual(false)
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 6 })).toEqual(false)
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 7 })).toEqual(false)
      expect(lebtNaechsteRunde({ status: 'lebt', nachbarn: 8 })).toEqual(false)
    })
  })
  describe('tote zelle', () => {
    test('mit 3 nachbarn erzeugt neues leben', () => {
      expect(lebtNaechsteRunde({ status: 'tod', nachbarn: 3 })).toEqual(true)
    })
  })
})

test('evolution', () => {
  //prettier-ignore
  //@formatter:off
  const board = tick([
                         '11/9',
                '10/10',
        '9/11',
    ])
  //@formatter:on
  expect(board).toEqual(['10/10'])
  expect(tick(board)).toEqual([])
})
